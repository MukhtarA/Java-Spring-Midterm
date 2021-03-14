package mid.term.dao;

import mid.term.profile.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDataBase {
    private static final List<Profile> USER_PROFILES =  new ArrayList<>();

    static {
        USER_PROFILES.add(new Profile(UUID.randomUUID(), "user1", "Front-end dev", null));
        USER_PROFILES.add(new Profile(UUID.randomUUID(), "user2", "Back-end dev", null));
    }

    public static List<Profile> getUserProfiles() {
        return USER_PROFILES;
    }
}
