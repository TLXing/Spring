package com.dev.test;

import com.alibaba.fastjson.JSONObject;
import com.dev.util.RedisHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@SpringBootTest
public class Test01 {
    @Resource(name = "druidDataSource02")
    DataSource dataSource;

    List<Tree> trees = new ArrayList<>();

    @Test
    void Test01(){

        //Connection connection = dataSource.getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT * FROM books");
        System.out.println( srs.getMetaData().getColumnCount());
        System.out.println(RedisHelper.getString("name"));
        System.out.println("Test01");
    }

    @Test
    void Test02(){

        String json = "[{\"id\":\"001\",\"name\":\"文件1\",\"children\":[{\"id\":\"002\",\"name\":\"文件夹1-1\"},{\"id\":\"003\",\"name\":\"文件夹1-2\",\"children\":[{\"id\":\"007\",\"name\":\"文件夹4-1\"},{\"id\":\"008\",\"name\":\"文件夹7-2\"}]}]},{\"id\":\"004\",\"name\":\"文件2\",\"children\":[{\"id\":\"005\",\"name\":\"文件夹2-1\"},{\"id\":\"006\",\"name\":\"文件夹2-2\"}]}]";
         List<Node> nodes = JSONObject.parseArray(json,Node.class);

        List<Tree> t =  getTree(nodes,"",1);
        System.out.println(nodes.toString());
        System.out.println(t.toString());
        List<Node> nss = buildTree(t,"");
        System.out.println(nss.toString());
    }

    List<Tree> getTree(List<Node> nodes,String pid,int depth){

        for (Node n:nodes
             ) {
            Tree tree = getTreeNode(n,pid, depth);
            if (tree != null)
                trees.add(tree);

            if (n.getChildren() != null)
            {
                getTree(n.getChildren(), n.getId(), ++depth);
            }
        }

        if(nodes == null){
             return null;
        }
        return trees;
    }

    private List<Node> buildTree(List<Tree> treeList,String pid){
        List<Node> ns = new ArrayList<>();
            for (Tree t: treeList
            ) {
                if(pid ==  t.getParentId()){
                    Node node = new Node();
                    node.setId(t.getId());
                    node.setName(t.getDirectoryName());
                    ns.add(node);
                    node.setChildren(buildTree(treeList,node.getId()));
                }
            }
            return ns;
    }

    private Tree getTreeNode(Node d,String pid, int depth)
    {
        try
        {
            Tree tree = new Tree ();
            tree.setId(d.getId());
            tree.setDirectoryName(d.getName());
            tree.setParentId(pid);
            tree.setDepth(depth);
            return tree;
        }
        catch (Exception e)
        {

            return null;
        }

    }

}
