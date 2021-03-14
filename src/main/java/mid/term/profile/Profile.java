package mid.term.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Profile {

    private final UUID userProfileId;
    private final String username;
    private final String position;
    private String userProfileImageLink; // S3 key

    public Profile(UUID userProfileId,
                   String username,
                   String position,
                   String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.position = position;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public String getPosition() {
        return position;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile that = (Profile) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(position, that.position) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, position, userProfileImageLink);
    }
}
