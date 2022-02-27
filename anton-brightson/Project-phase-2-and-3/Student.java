public class Student{
    private String logFname;
    private String logLname;
    private String logYrgroup;
    private String logGPA;
    private String logDOB;

    public String getFname(){
      return logFname; 
    }

    public void setFname(String logFname){
        this.logFname = logFname;
    }

    public String getLname(){
        return logLname;
    }

    public void setLname(String logLname){
        this.logLname = logLname;
    }

    public int getYrgrp(){
        return logYrgroup;
    }

    public void setYrgrp(String logYrgroup){
        this.logYrgroup = logYrgroup;
    }

    public int getGPA(){
        return logGPA;
    }

    public void setGPA(String logGPA){
        this.logGPA = logGPA;
    }

    public String getDOB(){
        return logDOB;
    }

    public void setDOB(String logDOB){
        this.logDOB = logDOB;
    }

}