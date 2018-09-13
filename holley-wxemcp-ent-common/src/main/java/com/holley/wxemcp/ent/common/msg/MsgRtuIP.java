package com.holley.wxemcp.ent.common.msg;

import java.io.Serializable;

public class MsgRtuIP extends MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;
    int                       IP1;
    int                       IP2;
    int                       IP3;
    int                       IP4;
    int                       mask1;
    int                       mask2;
    int                       mask3;
    int                       mask4;
    int                       gateway1;
    int                       gateway2;
    int                       gateway3;
    int                       gateway4;

    /*
     * byte proxy_type; byte proxy_ip1; byte proxy_ip2; byte proxy_ip3; byte proxy_ip4; byte proxy_port; byte
     * proxy_connecttype; byte usernamelen;
     */

    public int getIP1() {
        return IP1;
    }

    public void setIP1(int iP1) {
        IP1 = iP1;
    }

    public int getIP2() {
        return IP2;
    }

    public void setIP2(int iP2) {
        IP2 = iP2;
    }

    public int getIP3() {
        return IP3;
    }

    public void setIP3(int iP3) {
        IP3 = iP3;
    }

    public int getIP4() {
        return IP4;
    }

    public void setIP4(int iP4) {
        IP4 = iP4;
    }

    public int getMask1() {
        return mask1;
    }

    public void setMask1(int mask1) {
        this.mask1 = mask1;
    }

    public int getMask2() {
        return mask2;
    }

    public void setMask2(int mask2) {
        this.mask2 = mask2;
    }

    public int getMask3() {
        return mask3;
    }

    public void setMask3(int mask3) {
        this.mask3 = mask3;
    }

    public int getMask4() {
        return mask4;
    }

    public void setMask4(int mask4) {
        this.mask4 = mask4;
    }

    public int getGateway1() {
        return gateway1;
    }

    public void setGateway1(int gateway1) {
        this.gateway1 = gateway1;
    }

    public int getGateway2() {
        return gateway2;
    }

    public void setGateway2(int gateway2) {
        this.gateway2 = gateway2;
    }

    public int getGateway3() {
        return gateway3;
    }

    public void setGateway3(int gateway3) {
        this.gateway3 = gateway3;
    }

    public int getGateway4() {
        return gateway4;
    }

    public void setGateway4(int gateway4) {
        this.gateway4 = gateway4;
    }

}
