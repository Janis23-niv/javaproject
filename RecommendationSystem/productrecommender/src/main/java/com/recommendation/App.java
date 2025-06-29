package com.recommendation;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class App {
    public static void main(String[] args) {
        try {
            // Load dataset (comma-separated)
            File file = new File("data.csv");
            DataModel model = new FileDataModel(file, ",");

            // Define user similarity using Pearson correlation
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Define neighborhood with 2 nearest users
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

            // Create the recommender
            Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Recommend 3 items for user 1 (you can change the user ID)
            long userId = 1L;
            List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

            System.out.println("Recommendations for user " + userId + ":");
            if (recommendations.isEmpty()) {
                System.out.println("  (No recommendations found)");
            } else {
                for (RecommendedItem rec : recommendations) {
                    System.out.println("  Item ID: " + rec.getItemID() +
                                       " | Estimated Preference: " + rec.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
