package org.fundaciobit.plugins.validatesignature.integra.test;


public class TypeFormatProfile {

   String type;
   String format;
   String profile;
   
  public TypeFormatProfile(String type, String format, String profile) {
    super();
    this.type = type;
    this.format = format;
    this.profile = profile;
  }
  
  public TypeFormatProfile() {}
  
  public void setType(String type) {
    this.type=type; 
  }
  public void setFormat(String format) {
    this.format=format;
  }
  public void setProfile(String profile) {
    this.profile=profile;
  }

  public String getType() {
    return type;
  }
  public String getFormat() {
    return format;
  }
  public String getProfile() {
    return profile;
  }
  
  
}
