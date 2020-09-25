package com;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyGenerator {

	 public void generate() throws Exception {
	        List<String> warnings = new ArrayList<String>();
	        boolean overwrite = true;
	        
	        String classpath=this.getClass().getResource("/").getPath().replaceFirst("/", "");
	        String webappRoot = classpath.replaceAll("target/classes/", "");
	        webappRoot=webappRoot.replaceAll("%20", " ");
	        System.out.println(webappRoot);
	        File configFile = new File(webappRoot+"\\src\\main\\webapp\\GeneratorConfig.xml");
	        ConfigurationParser cp = new ConfigurationParser(warnings);
	        Configuration config = cp.parseConfiguration(configFile);
	        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	        myBatisGenerator.generate(null);
	    }

	    public static void main(String[] args) throws Exception {
	        try {
	            MyGenerator myGenerator = new MyGenerator();
	            myGenerator.generate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
