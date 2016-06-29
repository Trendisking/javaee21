package com.kaishengit.test;

import com.google.common.collect.Lists;
import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.pojo.Node;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 20330 on 2016/6/28.
 */
public class NodeMapperTestCase {
    private Logger logger= LoggerFactory.getLogger(NodeMapperTestCase.class);
    @Test
    public void testFindById(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        NodeMapper nodeMapper=sqlSession.getMapper(NodeMapper.class);
        Node node=nodeMapper.findById(1);
        node=nodeMapper.findById(1);
        node=nodeMapper.findById(1);
        node=nodeMapper.findById(1);
        logger.debug("{}",node);
        sqlSession.close();

        SqlSession sqlSession2=MyBatisUtil.getSqlSession();
        NodeMapper nodeMapper2=sqlSession2.getMapper(NodeMapper.class);
        Node node2=nodeMapper2.findById(1);
        node2=nodeMapper2.findById(1);
        node2=nodeMapper2.findById(1);
        node2=nodeMapper2.findById(1);
        logger.debug("{}",node2);
        sqlSession2.close();

    }

    @Test
    public void testBatchSave(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        NodeMapper nodeMapper=sqlSession.getMapper(NodeMapper.class);
        List<Node> nodeList= Lists.newArrayList();
        nodeList.add(new Node("node1"));
        nodeList.add(new Node("node2"));
        nodeList.add(new Node("node3"));
        nodeList.add(new Node("node4"));
        nodeMapper.batchSave(nodeList);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testFindByIds(){
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        NodeMapper nodeMapper=sqlSession.getMapper(NodeMapper.class);
        List<Integer> idList=Lists.newArrayList(1,2,3);
        List<Node> nodeList=nodeMapper.findByIds(idList);
        for(Node node:nodeList){
            logger.debug("{}",node);
        }
        sqlSession.close();
    }
}
