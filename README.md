#Rosebank Project

###Description: it is a project to test Get, Post, Put and Delete methods for a bank Endpoint.

First of all, you need to create your own Endpoint at https://mockapi.io/projects with the properties listed above:

 id
 Name
 LastName
 AccountNumber
 Ammount
 TransactionType
 Email
 Active
 Country
 Telephone

<p align="center">
  <img alt="Maps image" src="https://s3.amazonaws.com/images.rousangela.com/mockapi.ioprojects.jpeg">
</p>

###Steps to run the Rosebank Project
1. Clone the project
2. Build the POM: go to pom.xml, click on the maven option in the right sidebar and then click on refresh to download the following libraries dependencies:
>   
     <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>4.3.3</version>
      <scope>test</scope>
     </dependency>
     
     <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.5</version>
     </dependency>

     <dependency>
      <groupId>com.github.javafaker</groupId>
      <artifactId>javafaker</artifactId>
      <version>0.15</version>
     </dependency>

    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.14.3</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>

3. Replace the URL in TransactionTest Class with the EndPoint you previously created, to be able to run the project.

4. Go to TransactionTest Class to execute the tests, go to each test and then click on the Run button located in the left side of the code line.

<p align="center">
  <img alt="Maps image" src="https://s3.amazonaws.com/images.rousangela.com/Project.jpeg">
</p>

 
