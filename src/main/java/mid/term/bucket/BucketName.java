package mid.term.bucket;

public enum BucketName {
    PROFILE_IMAGE("midterm-spring");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
