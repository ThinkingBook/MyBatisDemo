import com.thinkbook.dao.UserMapper;
import com.thinkbook.pojo.User;
import com.thinkbook.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        //方法一:
        //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        //1、查询所有用户
        List<User> users = mapper.selectUser();
        for (User user: users){
            System.out.println(user);
        }
        //2.根据姓名和密码查询用户,使用@Param传递参数
        User user = mapper.selectUserByNP("李四","987654");
        System.out.println(user);
        //3.根据姓名和密码查询用户,使用map传递参数
        Map<String, Object> map = new HashMap<>();
        map.put("username","李四");
        map.put("pwd","987654");
        User user1 = mapper.selectUserByNP2(map);
        System.out.println(user);
        //4.添加一条数据
        User user2 = new User(4,"thinkbook","123123");
        int addIndex = mapper.addUser(user);
        System.out.println(addIndex);
        session.commit();//提交事务
        //5.更新数据
        User user3 = new User(1,"thinkBook","111111");
        int updateIndex = mapper.updateUser(user);
        System.out.println(updateIndex);
        session.commit();
        //6.删除数据
        int delIndex = mapper.delUser(3);
        System.out.println(delIndex);
        session.commit();
        session.close();
    }
}