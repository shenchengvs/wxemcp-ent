package com.holley.wxemcp.ent.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.constants.TreeNodeStateEnum;
import com.holley.platform.common.dataobject.TreeNode;
import com.holley.platform.model.def.EntBaseInfo;
import com.holley.wxemcp.ent.common.constants.ObjectTypeEnum;
import com.holley.wxemcp.ent.model.dic.DicBusinessType;
import com.holley.wxemcp.ent.model.dic.DicCity;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;

public class TreeUtil {

    public static TreeNode convertCity2TreeNode(DicCity city) {
        TreeNode node = new TreeNode();
        node.text = city.getName();
        node.id = city.getCityid().toString();
        node.type = city.getRank().toString();
        if (ObjectTypeEnum.OBJ_PROVINCE.getIntValue() == Integer.parseInt(node.type)) {
            node.iconCls = "OBJ_PROVINCE";
        } else if (ObjectTypeEnum.OBJ_CITY.getIntValue() == Integer.parseInt(node.type)) {
            node.iconCls = "OBJ_CITY";
        } else if (ObjectTypeEnum.OBJ_DISTRICT.getIntValue() == Integer.parseInt(node.type)) {
            node.iconCls = "OBJ_DISTRICT";
        }
        return node;
    }

    public static TreeNode getDefaultNode() {
        TreeNode node = new TreeNode();
        node.text = "加载中...";
        node.type = "loading";
        // 禁止点击
        Map<String, Boolean> state = new HashMap<String, Boolean>();
        state.put(TreeNodeStateEnum.DISABLED.getValue(), true);
        node.state = state;
        return node;
    }

    public static TreeNode convertBusiness2TreeNode(DicBusinessType business) {
        TreeNode node = new TreeNode();
        node.text = business.getName();
        node.id = business.getBusinesstypeid().toString();
        return node;
    }

    public static TreeNode convertEnterprise2TreeNode(ObjEnterprise record) {
        TreeNode node = new TreeNode();
        node.data = record.getEid().toString();
        node.type = record.getOwnertype().toString();
        node.id = node.data + Globals.COLUMNSPLIT + node.type;
        node.text = record.getDisc();
        return node;

    }

    public static TreeNode convertEnterprise2TreeNode(EntBaseInfo entBaseInfo) {
        TreeNode node = new TreeNode();
        node.data = entBaseInfo.getEid().toString();
        // node.type = "ent";
        node.type = entBaseInfo.getOwnertype().toString();
        node.id = node.data + Globals.COLUMNSPLIT + node.type;
        node.text = entBaseInfo.getDisc();
        return node;

    }

    public static List<TreeNode> getEntByPid(List<EntBaseInfo> list, Integer peid, Integer eid, Integer selectId) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        TreeNode node;
        for (EntBaseInfo record : list) {
            if ((peid == null && eid != null && record.getEid() == eid) || (peid != null && record.getOwnerid() == peid)) {
                node = TreeUtil.convertEnterprise2TreeNode(record);
                if (selectId != null && selectId == NumberUtils.toInt(node.getData())) {
                    Map<String, Boolean> state = new HashMap<String, Boolean>();
                    state.put("selected", true);
                    node.setState(state);
                }
                nodeList.add(node);
            }
        }
        if (nodeList.size() == 0) {
            return nodeList;
        }
        List<TreeNode> children;
        for (TreeNode treeNode : nodeList) {
            children = getEntByPid(list, Integer.valueOf(treeNode.getData()), null, selectId);
            if (children != null && children.size() > 0) {
                treeNode.children = children;
                treeNode.leaf = false;
            } else {
                treeNode.leaf = true;
            }
        }
        return nodeList;
    }
}
