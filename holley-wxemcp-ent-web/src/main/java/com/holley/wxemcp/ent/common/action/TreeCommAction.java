package com.holley.wxemcp.ent.common.action;

import java.util.ArrayList;
import java.util.List;

import com.holley.platform.common.dataobject.TreeNode;
import com.holley.platform.model.def.EntBaseInfo;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.util.TreeHelper;
import com.holley.wxemcp.ent.common.util.TreeUtil;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.service.common.TreeCommService;
import com.holley.wxemcp.ent.service.obj.EntDevService;

public class TreeCommAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private TreeCommService   treeCommService;
    private EntDevService     entDevService;
    private List<TreeNode>    treeNodes;

    /**
     * 异步加载企业树<br>
     * 节点类型:企业节点
     * 
     * @return
     */
    public String loadEntTree() {
        WxemcpEntWebUser webUser = this.getUser();
        Integer departmentid = webUser.getEntId();
        String pid = this.getParameter("nodeid");
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        List<EntBaseInfo> entLit = null;
        if (pid == null) {
            if (departmentid < 0) {
                entLit = treeCommService.selectChildEnt(departmentid);
                nodeList = TreeHelper.makeEntTreeByPid(entLit, departmentid);
            } else {
                ObjEnterprise ent = entDevService.selectEnterpriseByPK(departmentid);
                TreeNode node = TreeUtil.convertEnterprise2TreeNode(ent);
                nodeList.add(node);
            }
        } else {
            entLit = treeCommService.selectChildEnt(Integer.valueOf(pid));
            nodeList = TreeHelper.makeEntTreeByPid(entLit, Integer.valueOf(pid));
        }
        this.treeNodes = nodeList;
        return SUCCESS;
    }

    public void setTreeCommService(TreeCommService treeCommService) {
        this.treeCommService = treeCommService;
    }

    public void setEntDevService(EntDevService entDevService) {
        this.entDevService = entDevService;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

}
