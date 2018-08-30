

Per usar en JBOSS 5.x s'han d'usar les següents dependències:

  <dependency>
    <groupId>org.apache.santuario</groupId>
    <artifactId>xmlsec</artifactId>
    <version>1.5.5</version>
  </dependency>

  <dependency>
    <groupId>org.fundaciobit.pluginsib.validatesignature</groupId>
    <artifactId>pluginsib-validatesignature-integra</artifactId>
    <version>2.0.0</version>

    <exclusions>
        <!-- Eliminam tota la comunicació AXIS -->
        <exclusion>  
          <groupId>org.apache.axis</groupId>
          <artifactId>axis</artifactId>
        </exclusion>
        <exclusion>  
          <groupId>org.apache.axis</groupId>
          <artifactId>axis-jaxrpc</artifactId>
        </exclusion>
        <exclusion>  
          <groupId>org.apache.axis</groupId>
          <artifactId>axis-saaj</artifactId>
        </exclusion>
        <exclusion>  
          <groupId>org.apache.santuario</groupId>
          <artifactId>xmlsec</artifactId>
        </exclusion>
        <exclusion>  
          <groupId>com.sun.xml.wss</groupId>
          <artifactId>xws-security</artifactId>
        </exclusion>
        
        <!-- Altres llibreries no necessaries -->
        <exclusion>  
          <groupId>xerces</groupId>
          <artifactId>xercesImpl</artifactId>
        </exclusion>

        <exclusion>  
          <groupId>com.sun.xml.bind</groupId>
          <artifactId>jaxb-impl</artifactId>
        </exclusion>

        <exclusion>  
          <groupId>xalan</groupId>
          <artifactId>xalan</artifactId>
        </exclusion>

        <exclusion>  
          <groupId>org.slf4j</groupId>
          <artifactId>log4j-over-slf4j</artifactId>
        </exclusion>

        <exclusion>  
          <groupId>org.slf4j</groupId>
          <artifactId>jcl-over-slf4j</artifactId>
        </exclusion>
        
        <exclusion>  
          <groupId>org.apache.ws.security</groupId>
          <artifactId>wss4j</artifactId>
        </exclusion>

        <exclusion>  
          <groupId>org.apache.santuario</groupId>
          <artifactId>xmlsec</artifactId>
        </exclusion>
        
      </exclusions> 
       
  </dependency>
