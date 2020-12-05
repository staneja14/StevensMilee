## Stevens Milee Project

This repository contains integrated code for the project. There are two main folders:

1. **StevensMilee**: This folder contains code for UI. Angular version 1.xx is used for integrating REST APIs made using Java's Spring Boot Framework.
2. **coursesreview**: This folder contains code for Backend. Different packages have a list of various APIs that are consumed in Frontend. It also contains, Swagger                       API documentation that is used for makinng the API documentation structured. 

3. **API Endpoints** : APIs are hosted on Amazon EC2. 

4. **Link to REST API Endpoints Documentation**: http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/swagger-ui.html


## Build Instructions

## For Frontend

  1. Go to the Github repository

  2. Clone the project using command:

     “git clone <repository-link>”

  3. Open Visual Studio. Go to Extensions ---> Search for “Live Server” extension and “Beautify” code. Install these two extensions

  4. Go to Files. Click on “Import Projects from File System” and Open the folder “StevensMilee” from the project you just cloned

  5. Right click on Index.html file and click on “Open with Live Server”
  

## For Database Connection

  1. Install DBeaver

  2. Click on + sign on the left menu

  3. Add database name, username and password

  4. Click on “Test Connection” to check whether the connection is successful

  5. Be sure to “Start” the db instance from AWS Console
  

## For Backend

  1. Install Spring Tool Suite

  2. Clone the project from Github repository

  3. Go to files and open the project

  4. Right click on the project folder, select ‘Maven’ and click on ‘Update Project’

  5. Click on CoursesReviewApplication.java file in com.stevensportal.coursesreview package and run the file
  
  

