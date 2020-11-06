package project.oscarvision.models;

public class PostResponse{
   String category;
   String entity;
   boolean winner;
   int year;
   public String getCategory(){
      return category;
   }
   public String getEntity(){
      return entity;
   }
   public boolean getWinner(){
      return winner;
   }
   public int getYear(){
      return year;
   }
   public void setCategory(String category){
      this.category = category;
   }
   public void setEntity(String entity){
      this.entity = entity;
   }
   public void setWinner(boolean winner){
      this.winner = winner;
   }
   public void setYear(int year){
      this.year = year;
   }
}