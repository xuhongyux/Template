package com.xiayu.parsion.xml;

import com.xiayu.parsion.xml.BpmnGatewayEnum;

import com.google.common.collect.Lists;
import com.xiayu.parsion.xml.bo.GatewayBo;
import com.xiayu.parsion.xml.bo.SequenceFlowBo;
import com.xiayu.parsion.xml.bo.TaskBo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 解析XML文件
 *
 * @author xuhongyu
 * @create 2021-04-19 11:03
 */
public class Test {


    public static Map<String, SequenceFlowBo> sequenceFlowMapGlobal = null;
    public static Map<String, TaskBo> taskMapGlobal = null;
    public static Map<String, GatewayBo> gatewayGlobal = null;
    public static TaskBo startTaskBoGlobal = null;
    public static TaskBo endTaskBoGlobal = null;


    public static void main(String[] args) throws DocumentException {


        // 注意子节点还会有子节点可以继续遍历
            /*for (Element element : rootElements.elements()) {
                List<Element> elements1 = element.elements();
                // 获取具体的哪个element
                Element startEvent = element.element("startEvent");
                // 通过属性名称获取属性值
                String s = startEvent.attributeValue("");
                // 通过元素标签名称获得对应的元素文本信息
                String s1 = startEvent.elementText("");
                System.out.println(startEvent.getName());
            }
            String id = elements.get(0).attributeValue("id");*/

    }

    @org.junit.Test
    public void test() throws DocumentException {
        long lasting = System.currentTimeMillis();
        File a = new File("C:\\Users\\WFX-001\\Desktop\\XML文件\\diagram无路由.bpmn");
        File b = new File("C:\\Users\\WFX-001\\Desktop\\XML文件\\diagram.bpmn");
        // 创建SAXReadr对象
        SAXReader reader = new SAXReader();
        // 读取文件内容
        Document doc = reader.read(b);
        // 获取根节点数据
        Element root = doc.getRootElement();
        // 遍历子节点
        Element rootElement = (Element) doc.getRootElement().elements().get(0);
        //Xml文件数据封装
        XmlDataEncapsulation(rootElement);

        // 递归处理
        BpmnItem bpmnItem = new BpmnItem();

        // 递归填充数据
        recursionProcess(bpmnItem, null);
        // 清理缓存
        memoryClean();
    }

    /**
     * 清理缓存
     */
    private void memoryClean() {
        sequenceFlowMapGlobal = null;
        taskMapGlobal = null;
        gatewayGlobal = null;
        startTaskBoGlobal = null;
        endTaskBoGlobal = null;
    }


    /**
     * Xml文件数据封装
     *
     * @param rootElement
     */
    private void XmlDataEncapsulation(Element rootElement) {
        // 封装边  sequenceFlow
        List<Element> sequenceFlows = rootElement.elements("sequenceFlow");
        List<SequenceFlowBo> sequenceFlowList = Lists.newArrayList();
        for (Element sequenceFlow : sequenceFlows) {
            String id = sequenceFlow.attributeValue("id");
            String sourceRef = sequenceFlow.attributeValue("sourceRef");
            String targetRef = sequenceFlow.attributeValue("targetRef");
            SequenceFlowBo sequenceFlowBo = new SequenceFlowBo(id, sourceRef, targetRef);
            sequenceFlowList.add(sequenceFlowBo);
        }
        Map<String, SequenceFlowBo> sequenceFlowMap = sequenceFlowList.stream().collect(Collectors.toMap(po -> po.getId(), po -> po));
        sequenceFlowMapGlobal = sequenceFlowMap;

        // 封装属性 task
        List<Element> taskElement = rootElement.elements("task");
        List<TaskBo> taskList = Lists.newArrayList();
        for (Element element : taskElement) {
            String id = element.attributeValue("id");
            String name = element.attributeValue("name");
            List<String> incomingList = Lists.newArrayList();
            List<String> outgoingList = Lists.newArrayList();

            List<Element> incoming = element.elements("incoming");
            for (Element element1 : incoming) {
                incomingList.add(element1.getTextTrim());
            }
            List<Element> outgoing = element.elements("outgoing");
            for (Element element1 : outgoing) {
                outgoingList.add(element1.getTextTrim());
            }
            // 数据封装
            TaskBo taskBo = new TaskBo();
            taskBo.setId(id);
            taskBo.setName(name);
            taskBo.setIncomingList(incomingList);
            taskBo.setOutgoing(outgoingList);

            taskList.add(taskBo);
        }
        Map<String, TaskBo> taskMap = taskList.stream().collect(Collectors.toMap(po -> po.getId(), po -> po));
        taskMapGlobal = taskMap;

        List<GatewayBo> gatewayList = Lists.newArrayList();
        // 封装路由 parallelGateway
        List<Element> parallelGateway = rootElement.elements("parallelGateway");
        for (Element element : parallelGateway) {
            String id = element.attributeValue("id");
            String name = element.attributeValue("name");
            List<String> incomingList = Lists.newArrayList();
            List<String> outgoingList = Lists.newArrayList();

            List<Element> incoming = element.elements("incoming");
            for (Element element1 : incoming) {
                incomingList.add(element1.getTextTrim());
            }
            List<Element> outgoing = element.elements("outgoing");
            for (Element element1 : outgoing) {
                outgoingList.add(element1.getTextTrim());
            }
            // 封装数据
            GatewayBo gatewayBo = new GatewayBo();
            gatewayBo.setId(id);
            gatewayBo.setName(name);
            gatewayBo.setIncomingList(incomingList);
            gatewayBo.setOutgoing(outgoingList);
            gatewayBo.setGateWayType("parallelGateway");
            gatewayList.add(gatewayBo);
        }

        // 封装路由 exclusiveGateway
        List<Element> exclusiveGateway = rootElement.elements("exclusiveGateway");
        for (Element element : exclusiveGateway) {
            String id = element.attributeValue("id");
            String name = element.attributeValue("name");
            List<String> incomingList = Lists.newArrayList();
            List<String> outgoingList = Lists.newArrayList();

            List<Element> incoming = element.elements("incoming");
            for (Element element1 : incoming) {
                incomingList.add(element1.getTextTrim());
            }
            List<Element> outgoing = element.elements("outgoing");
            for (Element element1 : outgoing) {
                outgoingList.add(element1.getTextTrim());
            }
            // 封装数据
            GatewayBo gatewayBo = new GatewayBo();
            gatewayBo.setId(id);
            gatewayBo.setName(name);
            gatewayBo.setIncomingList(incomingList);
            gatewayBo.setOutgoing(outgoingList);
            gatewayBo.setGateWayType("exclusiveGateway");
            gatewayList.add(gatewayBo);
        }
        Map<String, GatewayBo> gatewayMap = gatewayList.stream().collect(Collectors.toMap(po -> po.getId(), po -> po));
        gatewayGlobal = gatewayMap;

        // 获取开始元素
        Element startEvent = rootElement.element("startEvent");
        String startEventId = startEvent.attributeValue("id");
        String startEventName = startEvent.attributeValue("name");
        List<Element> outgoings = startEvent.elements("outgoing");
        List<String> outgoingList = Lists.newArrayList();
        for (Element outgoing : outgoings) {
            String textTrim = outgoing.getTextTrim();
            outgoingList.add(textTrim);
        }
        TaskBo starTaskBo = new TaskBo();
        starTaskBo.setId(startEventId);
        starTaskBo.setName(startEventName);
        starTaskBo.setOutgoing(outgoingList);

        // 获取结束元素
        Element endEvent = rootElement.element("endEvent");
        String endEventId = endEvent.attributeValue("id");
        String endEventName = endEvent.attributeValue("name");
        TaskBo endTaskBo = new TaskBo();
        endTaskBo.setId(endEventId);
        endTaskBo.setName(endEventName);

        startTaskBoGlobal = starTaskBo;
        endTaskBoGlobal = endTaskBo;
    }

    /**
     * 递归处理
     */
    private static void recursionProcess(BpmnItem bpmnItem, List<String> outgoingIds) {
        // 第一个
        if (outgoingIds == null) {
            String name = startTaskBoGlobal.getName();
            List<String> outgoingIdsSon = startTaskBoGlobal.getOutgoing();

            List<String> activities = Lists.newArrayList();
            activities.add(name);
            bpmnItem.setActivities(activities);

            recursionProcess(bpmnItem, outgoingIdsSon);

        } else {

            BpmnItem bpmnItemSon = new BpmnItem();
            bpmnItem.getNextBpmnItems().add(bpmnItemSon);

            List<String> taskNames = Lists.newArrayList();
            for (String outgoingId : outgoingIds) {
                SequenceFlowBo sequenceFlowBo = sequenceFlowMapGlobal.get(outgoingId);

                String targetRef = sequenceFlowBo.getTargetRef();
                TaskBo taskBo = taskMapGlobal.get(targetRef);
                // 都是正常节点的情况
                if (taskBo!= null){
                    List<String> outgoing = taskBo.getOutgoing();
                    taskNames.add(taskBo.getName());
                    recursionProcess(bpmnItemSon,outgoing);
                    continue;
                }

                // 路由节点
                if(gatewayGlobal.containsKey(targetRef)){
                    GatewayBo gatewayBo = gatewayGlobal.get(targetRef);

                    String gateWayType = gatewayBo.getGateWayType();
                    bpmnItemSon.setGateway(BpmnGatewayEnum.EXCLUSIVE);
                    List<String> outgoing = gatewayBo.getOutgoing();
                    recursionProcess(bpmnItemSon,outgoing);
                    continue;
                }

                // 结束节点
                if(endTaskBoGlobal.getId().equals(targetRef)){
                    taskNames.add(endTaskBoGlobal.getName());
                    continue;
                }

            }
            bpmnItemSon.setActivities(taskNames);

        }

    }

}
