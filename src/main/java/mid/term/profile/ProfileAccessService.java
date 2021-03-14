package mid.term.profile;

import mid.term.dao.UserDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileAccessService {

    private final UserDataBase userDataBase;

    @Autowired
    public ProfileAccessService(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    List<Profile> getUserProfiles() {
        return userDataBase.getUserProfiles();
    }
}