//package com.example.sqltest;
//
//import com.example.entity.primary.Student;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//
///**
// * 关于在y一般test方法中@Autowired不生效原因：
// * 在Test方法执行的时候，并不会给你创建容器，
// * junit也不知道你是否在使用spring，
// * 默认单例模式下没有容器也就不会有@Autowired自动装配有效
// */
//@ComponentScan("com.example")
//public class StudentTest {
//
//
//
//    @Test
//    public void selectTest() throws Exception {
//
////        String resource = "mybatis.xml";
////        InputStream inputStream = Resources.getResourceAsStream(resource);
////        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
////        SqlSession sqlSession = sqlSessionFactory.openSession();
////
////        /**
////         * mybatis创建的代理类
////         **/
////        StudentDao dao = sqlSession.getMapper(StudentDao.class);
////
////        Student student = dao.selectOne(01);
////        System.out.println(student);
////        sqlSession.close();
//    }
//
//    /**
//     * 通过getBean方式可以获取student的对象，而通过注入方式无法获取student对象
//     *
//     */
//    @Test
//    public void testAnnotation() {
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
//
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        Student student = (Student) applicationContext.getBean("student");
//
//        System.out.println(beanDefinitionNames);
//
//    }
//}
