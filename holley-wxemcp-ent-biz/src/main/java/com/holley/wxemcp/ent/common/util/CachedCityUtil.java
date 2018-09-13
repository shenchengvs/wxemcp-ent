package com.holley.wxemcp.ent.common.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.holley.platform.common.dataobject.TreeNode;
import com.holley.wxemcp.ent.common.constants.ObjectTypeEnum;
import com.holley.wxemcp.ent.dao.dic.DicCityMapper;
import com.holley.wxemcp.ent.model.dic.DicCity;
import com.holley.wxemcp.ent.model.dic.DicCityExample;

public class CachedCityUtil {

    private static DicCityMapper      dicCityMapper;
    /**
     * 树对象模块对应关系缓存
     */
    public static final List<DicCity> CITY = new ArrayList<DicCity>();

    public static void init() {
        // 初始化载入行政区域信息 double check
        if (CachedCityUtil.CITY.size() == 0) {
            synchronized (CachedCityUtil.CITY) {
                DicCityExample example = new DicCityExample();

                example.setOrderByClause("RANK,CITYID");
                CachedCityUtil.CITY.addAll(dicCityMapper.selectByExample(example));
            }
        }
    }

    /**
     * 根据查询首节点
     * 
     * @param dataAreaList
     */
    public static List<DicCity> getTopCity() {
        init();
        List<DicCity> result = new LinkedList<DicCity>();
        for (DicCity dicCity : CITY) {
            if (dicCity.getFatherid() == -1) {
                result.add(dicCity);
            }
        }
        return result;
    }

    /**
     * 通过父节点ID取子节点列表,但不包括cityid = fatherid的数据
     * 
     * @param parentmoduleid
     * @return
     */
    public static List<DicCity> getChildCityList(Short fatherid) {
        List<DicCity> result = new LinkedList<DicCity>();
        for (DicCity dicCity : CITY) {
            if (fatherid.equals(dicCity.getFatherid()) && dicCity.getFatherid() != -1) {
                result.add(dicCity);
            }
        }
        return result;
    }

    public static void refreshCache() {
        CachedCityUtil.CITY.clear();
        CachedCityUtil.init();
    }

    public static DicCity getCityByPrimaryKey(Short cityid) {
        for (DicCity dicCity : CITY) {
            if (cityid.equals(dicCity.getCityid())) {
                return dicCity;
            }
        }
        return null;
    }

    public static String getCityNameById(Short cityid) {
        DicCity city = getCityByPrimaryKey(cityid);
        return city == null ? "" : city.getName();
    }

    public static List<TreeNode> getTree() {
        return getCityByFatherId(1);// root
    }

    public static List<TreeNode> getCityByFatherId(int id) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode node;
        for (DicCity city : CITY) {
            if (id == city.getFatherid().intValue()) {
                node = TreeUtil.convertCity2TreeNode(city);
                result.add(node);
            }
        }
        if (result.size() == 0) {
            return result;
        }
        List<TreeNode> children;
        for (TreeNode treeNode : result) {
            children = getCityByFatherId(Integer.parseInt(treeNode.getId()));
            if (children != null && children.size() > 0) {
                treeNode.children = children;
            } else {
                treeNode.leaf = true;
            }
        }
        return result;
    }

    // 查询省
    public static List<DicCity> getProvince() {
        List<DicCity> list = new ArrayList<DicCity>();
        for (DicCity record : CITY) {
            if (record.getRank() == null) {
                continue;
            }
            if (ObjectTypeEnum.OBJ_PROVINCE.getIntValue() == record.getRank().intValue()) {
                list.add(record);
            }
        }
        return list;
    }

    // 查询市
    public static List<DicCity> getCityByProvince(Integer pid) {
        List<DicCity> list = new ArrayList<DicCity>();
        for (DicCity record : CITY) {
            if (ObjectTypeEnum.OBJ_CITY.getIntValue() == record.getRank().intValue() && record.getFatherid().intValue() == pid) {
                list.add(record);
            }
        }
        return list;
    }

    public void setDicCityMapper(DicCityMapper dicCityMapper) {
        CachedCityUtil.dicCityMapper = dicCityMapper;
    }
}
