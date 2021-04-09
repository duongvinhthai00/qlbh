package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.ProductDao;
import com.quanlybanhang.qlbh.dao.ViewDao;
import com.quanlybanhang.qlbh.dto.ProductDTO;
import com.quanlybanhang.qlbh.dto.ViewDTO;
import com.quanlybanhang.qlbh.entity.ProductEntity;
import com.quanlybanhang.qlbh.entity.ViewEntity;
import com.quanlybanhang.qlbh.exception.ExceptionGobal;
import com.quanlybanhang.qlbh.modalmapping.ProductMapper;
import com.quanlybanhang.qlbh.modalmapping.ViewMapper;
import com.quanlybanhang.qlbh.service.ViewService;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewDao viewDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public ViewDTO SaveView(ViewDTO viewDTO) {
        List<ViewEntity> list = viewDao.findAll();
        for(ViewEntity entity : list){
            if(viewDTO.getPro_id().getId() == entity.getPro_id().getId() && viewDTO.getUser_id().getId() == entity.getUser_id().getId()){
                ViewEntity viewEntity = entity;
                viewEntity.setView_number(1);
                viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
                return viewDTO;
            }
        }
        viewDTO.setView_number(1);
        ViewEntity viewEntity = ViewMapper.dto2Entity(viewDTO);
        viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
        return viewDTO;
    }

    public ViewDTO SaveRating(ViewDTO viewDTO) {
        List<ViewEntity> list = viewDao.findAll();
        for(ViewEntity entity : list){
            if(viewDTO.getPro_id().getId() == entity.getPro_id().getId() && viewDTO.getUser_id().getId() == entity.getUser_id().getId()){
                ViewEntity viewEntity = entity;
                viewEntity.setRating_number(viewDTO.getRating_number());
                viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
                return viewDTO;
            }
        }
        viewDTO.setView_number(1);
        ViewEntity viewEntity = ViewMapper.dto2Entity(viewDTO);
        viewDTO = ViewMapper.entity2DTO(viewDao.save(viewEntity));
        return viewDTO;
    }

    @Override
    public ViewDTO GetView(Integer pro_id,Integer user_id) {
        ViewDTO viewDTO = null;
        try {
            ViewEntity viewEntity = viewDao.GetView(pro_id,user_id);
            viewDTO = ViewMapper.entity2DTO(viewEntity);
        }catch (Exception e){
            throw new ExceptionGobal("Không Tìm Thấy View");
        }

        return viewDTO;
    }



    @Override
    public List<ProductDTO> GetListProductForUser(Integer pro_id, Integer group_id) {
        String input = "D://fileluu.csv";
        File file = new File(input);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<ProductEntity> productEntityList = new ArrayList<>();
        List<ProductDTO> productDTOList = new ArrayList<>();

        List<ViewEntity> viewEntities = viewDao.GetListView(group_id);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(input));
            for(ViewEntity entity : viewEntities){
                bw.write(entity.getUser_id().getId()+ ","+entity.getPro_id().getId()+ ","+entity.getView_number() + "\n");
            }
            bw.close();
            DataModel model = new FileDataModel(new File(input));
            ItemSimilarity itemSimilarity = new LogLikelihoodSimilarity(model);
            ItemBasedRecommender recommender = new GenericItemBasedRecommender(model, itemSimilarity);
            List<RecommendedItem> recommendations = recommender.mostSimilarItems(pro_id,15);
            for (RecommendedItem recommendation : recommendations){
                  System.out.println("work");
                  System.out.println(recommendation);
                  int ProductId = (int) recommendation.getItemID();
                  productEntityList.add(productDao.findById(ProductId).get());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if(productEntityList.size()>0){
            for(ProductEntity entity : productEntityList){
                productDTOList.add(ProductMapper.entity2DTO(entity));
            }
        }
        Comparator<ProductDTO> comp = new Comparator<ProductDTO>() {
            @Override
            public int compare(ProductDTO o1, ProductDTO o2) {
                if(o1.getPro_rate_number() > o2.getPro_rate_number()){
                    return -1;
                }else{
                    if(o1.getPro_rate_number()<o2.getPro_rate_number()){
                        return 1;
                    }
                }
                return 0;
            }
        };
        Collections.sort(productDTOList,comp);
        return productDTOList;
    }
}
