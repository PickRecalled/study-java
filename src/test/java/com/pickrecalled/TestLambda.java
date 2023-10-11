package com.pickrecalled;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestLambda {

    @Test
    public void test08() {
//        // lambda表达式将list转 map<String,List<String>>
//        Map<String, List<String>> materielSeqMap = opList.stream()
//            .collect(Collectors.groupingBy(DeviceDto::getDeviceCode, Collectors.mapping(DeviceDto::getDeviceName, Collectors.toList())));
//
//        // 转换为map，然后值根据排序获取最大的一个
//        tableMap = list.stream().filter(t -> t.getTargetSchemaName().equals(e.getKey()))
//            .collect(Collectors.groupingBy(DgComponentSjjrJtsjDatatable::getTargetTableName, Collectors.collectingAndThen(
//                Collectors.maxBy(Comparator.comparingInt(DgComponentSjjrJtsjDatatable::getVersion)), o -> o.get().getDataTableId())));
//
//        // groupby 之后再对集合进行去重操作
//        materielList.stream().collect(Collectors.groupingBy(BomDto::getRootId, Collectors
//            .collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BomDto::getMeasureParentCode))), ArrayList::new)));
    }

    @Test
    public void test07() {
        Map<Integer, String> uniqueData = new HashMap<>();
        // uniqueData.put(1, "A");
        // uniqueData.put(3, "A");
        // uniqueData.put(2, "A");
        // uniqueData.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> println(x.getKey()));
        //
        // List<Integer> integers =
        // uniqueData.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getKey).collect(Collectors.toList()).subList(0, 1);
        // System.out.println("integers:" + integers);

        Integer integer = Optional.of(uniqueData.entrySet()).orElse(new HashSet<>()).stream().sorted(Map.Entry.comparingByKey())
            .map(Map.Entry::getKey).max(Integer::compareTo).orElse(0);

        System.out.println("-----max integer-----:" + integer);

        // int asInt = uniqueData.entrySet().stream().sorted(Map.Entry.comparingByKey()).mapToInt(Map.Entry::getKey).max().getAsInt();
        //
        // System.out.println("-----asInt-----:" + asInt);
        //
        //
        //
        // List<Integer> integers1 =
        // uniqueData.entrySet().stream().sorted((Map.Entry<Integer, String> e1, Map.Entry<Integer, String> e2) -> e2.getKey() - e1.getKey())
        // .map(m -> m.getKey()).collect(Collectors.toList()).subList(0, 1);
        //
        // System.out.println("-------integers1------:" + integers1);
        //
        // Map<String, Integer> mapRepeat = new HashMap<>();
        // mapRepeat.put("aa", 1);
        // mapRepeat.put("bb", 45);
        // mapRepeat.put("cc", 32);
        // mapRepeat.put("dd", 226);
        // mapRepeat.put("ee", 16);
        // mapRepeat.put("ff", 320);
        // mapRepeat.put("gg", 99);
        // List<String> mobileList =
        // mapRepeat.entrySet().stream().sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e2.getValue() - e1.getValue())
        // .map(entry -> entry.getKey()).collect(Collectors.toList()).subList(0, 5);
        // System.out.println(JSON.toJSONString(mobileList));

    }

    public void println(Object x) {
        String s = String.valueOf(x);
        System.out.println("uniqueData:" + s);
    }

    @Test
    public void test06() {
        Map<String, String> operationMap = new HashMap<>();
        Boolean aBoolean = checkUserOperationContentTransfer(operationMap);
        System.out.println(aBoolean);
        operationMap.put("AA", "true");
        aBoolean = checkUserOperationContentTransfer(operationMap);
        System.out.println(aBoolean);
        operationMap.put("AA", "false");
        aBoolean = checkUserOperationContentTransfer(operationMap);
        System.out.println(aBoolean);
    }

    private Boolean checkUserOperationContentTransfer(Map<String, String> operationMap) {
        String trueString = operationMap.get("AA");
        return !StringUtils.isEmpty(trueString) && Boolean.TRUE.equals(Boolean.valueOf(trueString.toLowerCase()));
    }

    @Test
    public void test05() {
        List<UserOperationDetailLogDO> detailLogList = new ArrayList<>();
        detailLogList.add(new UserOperationDetailLogDO(""));
        detailLogList.add(new UserOperationDetailLogDO(""));
        detailLogList.add(new UserOperationDetailLogDO(""));
        String contentData =
            detailLogList.stream().map(UserOperationDetailLogDO::getContentData).filter(StringUtils::isNotBlank).collect(Collectors.joining(","));
        System.out.println("contentData:" + contentData);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class UserOperationDetailLogDO {
        private String contentData;
    }

    @Test
    public void test04() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list.size());
        list.addAll(getList());
        System.out.println(list.size());
    }

    private List<String> getList() {
        return new ArrayList<>();
    }

    @Test
    public void test03() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");

        System.out.println(s);
    }

    @Test
    public void test02() {
        List<String> codeList = new ArrayList<>();
        codeList.add("AAA");
        codeList.add("111");
        codeList.add("A1A1");
        codeList.add("BBB");
        String s = Optional.of(codeList).orElse(new ArrayList<>()).stream().filter(c -> c.equals("BBB")).findFirst().orElse(null);

        System.out.println("s===>" + s + " s == null ==>" + (s == null));
    }

    @Test
    public void test01() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L));
        userInfoList.add(new UserInfo(1L));
        userInfoList.add(new UserInfo(2L));
        userInfoList.add(new UserInfo(2L));
        userInfoList.add(new UserInfo(3L));

        Map<Long, List<UserInfo>> userInfoMap = userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getUserId));
        for (Map.Entry<Long, List<UserInfo>> entry : userInfoMap.entrySet()) {
            System.out.println("userInfoMap==>" + entry.getKey() + "---->" + entry.getValue());
        }

        Map<Long, List<StudentInfo>> studentInfoMap = userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getUserId,
            Collectors.mapping(u -> new StudentInfo(u.getUserId(), u.getUserName()), Collectors.toList())));
        for (Map.Entry<Long, List<StudentInfo>> entry : studentInfoMap.entrySet()) {
            System.out.println("1 studentInfoMap==>" + entry.getKey() + "---->" + entry.getValue());
        }

        List<StudentInfo> userDbList01 = new ArrayList<>();
        userDbList01.add(new StudentInfo(1L, "1A"));
        userDbList01.add(new StudentInfo(1L, "1B"));
        userDbList01.add(new StudentInfo(1L, "1C"));

        List<StudentInfo> userDbList02 = new ArrayList<>();
        userDbList02.add(new StudentInfo(2L, "2A"));
        userDbList02.add(new StudentInfo(2L, "2B"));
        userDbList02.add(new StudentInfo(2L, "2C"));

        for (Map.Entry<Long, List<StudentInfo>> entry : studentInfoMap.entrySet()) {
            studentInfoMap.put(entry.getKey(), userDbList01);
        }

        for (Map.Entry<Long, List<StudentInfo>> entry : studentInfoMap.entrySet()) {
            System.out.println("2 studentInfoMap==>" + entry.getKey() + "---->" + entry.getValue());
        }

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserInfo {
    private Long userId;

    private String userName;

    public UserInfo(Long userId) {
        this.userId = userId;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class StudentInfo {
    private Long userId;

    private String userName;
}