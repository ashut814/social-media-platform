package com.social.media;

import com.social.media.models.Profile;
import com.social.media.models.Users;
import com.social.media.repositories.GroupRepository;
import com.social.media.repositories.PostRepository;
import com.social.media.repositories.ProfileRepository;
import com.social.media.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.social.media.models.Post;
import com.social.media.models.SocialGroup;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ProfileRepository socialProfileRepository;
    private final PostRepository postRepository;

    public DataInitializer(UserRepository userRepository, GroupRepository groupRepository, ProfileRepository socialProfileRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            Users user1 = new Users();
            Users user2 = new Users();
            Users user3 = new Users();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // add users to groups

            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
             postRepository.save(post1);
             postRepository.save(post2);
             postRepository.save(post3);

            // Create some social profiles
            Profile profile1 = new Profile();
            Profile profile2 = new Profile();
            Profile profile3 = new Profile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepository)
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
        };
    }
}
