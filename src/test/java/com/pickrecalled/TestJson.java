package com.pickrecalled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

public class TestJson {

    public void test01(){
        String json = "{\n" +
                "  \"@type\": \"com.streamax.platform.api.base.vehicle.response.VehicleSnapResDTO\",\n" +
                "  \"appId\": 1,\n" +
                "  \"authId\": \"e565c13d90b3493e9c90342e04a5e715\",\n" +
                "  \"deviceId\": \"1367569335765435771\",\n" +
                "  \"deviceNo\": \"003F000537\",\n" +
                "  \"fleetList\": [\n" +
                "    {\n" +
                "      \"fleetId\": \"1352983589784136376\",\n" +
                "      \"fleetName\": \"test-0401\",\n" +
                "      \"path\": \"/1352976958354654810/1352983589784136376\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"primaryType\": 1,\n" +
                "  \"protocolType\": 1,\n" +
                "  \"snapHash\": \"77ae1f7443721bfea3b8632b24a0049f\",\n" +
                "  \"snapId\": 10,\n" +
                "  \"tenantId\": 1,\n" +
                "  \"vehicleColor\": 1,\n" +
                "  \"vehicleId\": \"1367569438844655584\",\n" +
                "  \"vehicleNumber\": \"003F000537\"\n" +
                "}";
        VehicleSnapResDTO vehicleSnapResDTO = JSON.parseObject(json, VehicleSnapResDTO.class);

    }


    @Data
    static class VehicleSnapResDTO{
        /**
         * 快照ID *
         */
        private Integer snapId;

        /**
         * 租户ID *
         */
        private Integer tenantId;

        /**
         * 应用ID *
         */
        private Integer appId;

        /**
         * 设备ID(运维需要) *
         */
        @JSONField(serializeUsing = ToStringSerializer.class)
        private Long deviceId;

        /**
         * 设备标识 *
         */
        private String authId;

        /**
         * 车辆ID *
         */
        @JSONField(serializeUsing = ToStringSerializer.class)
        private Long vehicleId;

        /**
         * 车牌号 *
         */
        private String vehicleNumber;

        /**
         * 车辆颜色 *
         */
        private Integer vehicleColor;

        /**
         * 设备编号
         */
        private String deviceNo;

        /**
         * 主/辅设备类型：1-主设备，2-辅助设备
         *
         */
        private Integer primaryType;

        /**
         * 设备别称
         */
        private String deviceAlias;

        /**
         * 设备卡号 *
         */
        private String simNo;

        /**
         * vin码 *
         */
        private String vin;

        /**
         * 协议类型 *
         */
        private Integer protocolType;

        /**
         * hash值 *
         */
        private String snapHash;

        /**
         * 扩展信息 *
         */
        private String addInfo;

    }
}
