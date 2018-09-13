package com.holley.wxemcp.ent.common.util;

import java.util.ArrayList;
import java.util.List;

import com.holley.platform.common.dataobject.TreeNode;
import com.holley.platform.model.def.EntBaseInfo;

/**
 * 树结构组成帮助类
 * 
 * @author zdd
 */
public class TreeHelper {

    /**
     * 根据企业编码，查找该企业的企业树，该企业节点为根节点
     * 
     * @param list
     * @param eid
     * @return
     */
    public static List<TreeNode> makeEntTreeByEid(List<EntBaseInfo> list, Integer eid) {
        if (list == null || list.size() == 0 || eid == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode node;
        if (eid > 0) {
            for (EntBaseInfo record : list) {
                if (eid == record.getEid().intValue()) {
                    node = TreeUtil.convertEnterprise2TreeNode(record);
                    List<TreeNode> cnodeList = makeEntTreeByPid(list, eid);
                    if (cnodeList != null && cnodeList.size() > 0) {
                        node.children = cnodeList;
                    }
                    result.add(node);
                }
            }
        } else {
            result = makeEntTreeByPid(list, eid);
        }
        return result;
    }

    /**
     * 根据父节点编码查找子节点列表
     * 
     * @param list
     * @param pid
     * @return
     */
    public static List<TreeNode> makeEntTreeByPid(List<EntBaseInfo> list, Integer pid) {
        if (list == null || list.size() == 0 || pid == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode node;
        for (EntBaseInfo record : list) {
            if (pid == record.getOwnerid().intValue()) {
                node = TreeUtil.convertEnterprise2TreeNode(record);
                result.add(node);
            }
        }
        if (result.size() == 0) {
            return result;
        }

        List<TreeNode> children;
        for (TreeNode treeNode : result) {
            children = makeEntTreeByPid(list, Integer.valueOf(treeNode.data));
            if (children != null && children.size() > 0) {
                treeNode.children = children;
            } else {
                treeNode.leaf = true;
            }
        }
        return result;
    }

}
