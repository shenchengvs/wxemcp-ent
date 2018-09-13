package com.holley.wxemcp.ent.common.util;

import java.util.ArrayList;
import java.util.List;

import com.holley.platform.common.dataobject.TreeNode;
import com.holley.wxemcp.ent.dao.dic.DicBusinessTypeMapper;
import com.holley.wxemcp.ent.model.dic.DicBusinessType;
import com.holley.wxemcp.ent.model.dic.DicBusinessTypeExample;

public class CachedBusinessTypeUtil {

    private static DicBusinessTypeMapper      dicBusinessTypeMapper;

    public static final List<DicBusinessType> BUSINESSTYPE = new ArrayList<DicBusinessType>();

    public static void init() {
        // 初始化载入行政区域信息 double check
        if (CachedBusinessTypeUtil.BUSINESSTYPE.size() == 0) {
            synchronized (CachedBusinessTypeUtil.BUSINESSTYPE) {
                DicBusinessTypeExample example = new DicBusinessTypeExample();

                example.setOrderByClause("BUSINESSTYPEID");
                CachedBusinessTypeUtil.BUSINESSTYPE.addAll(dicBusinessTypeMapper.selectByExample(example));
            }
        }
    }

    public static DicBusinessType getBusinessByPrimaryKey(Short businesstypeid) {
        for (DicBusinessType dicBusinesstype : BUSINESSTYPE) {
            if (businesstypeid.equals(dicBusinesstype.getBusinesstypeid())) {
                return dicBusinesstype;
            }
        }
        return null;
    }

    public static String getBusinessNameById(Short businesstypeid) {
        DicBusinessType record = getBusinessByPrimaryKey(businesstypeid);
        return record == null ? "" : record.getName();
    }

    public static List<TreeNode> getTree() {
        return getBusinessByFatherId(-1);// root
    }

    public static List<TreeNode> getBusinessByFatherId(int id) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode node;
        for (DicBusinessType type : BUSINESSTYPE) {
            if (id == type.getFatherid().intValue()) {
                node = TreeUtil.convertBusiness2TreeNode(type);
                result.add(node);
            }
        }
        if (result.size() == 0) {
            return result;
        }
        List<TreeNode> children;
        for (TreeNode treeNode : result) {
            children = getBusinessByFatherId(Integer.parseInt(treeNode.getId()));
            if (children != null && children.size() > 0) {
                treeNode.children = children;
            } else {
                treeNode.leaf = true;
            }
        }
        return result;
    }

    public void setDicBusinessTypeMapper(DicBusinessTypeMapper dicBusinessTypeMapper) {
        CachedBusinessTypeUtil.dicBusinessTypeMapper = dicBusinessTypeMapper;
    }

}
