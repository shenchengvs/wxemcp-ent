import com.holley.wxemcp.ent.common.cache.CacheCloudUtil;

public class Test {

    public static void main(String[] args) {
        CacheCloudUtil.setString("aa", "aa");
        System.out.println(CacheCloudUtil.getString("aa"));
        CacheCloudUtil.delKey("aa");
    }
}
