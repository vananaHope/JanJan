package project.opgg.VO;

public class User {

   private String userId;
   private int uLevel;
   private String uTier;
   private int grade;
   private int rankratio;
   
   public User() {
		super();
		// TODO Auto-generated constructor stub
	}
   
   public User(String userId, int grade, int rank) {
      this.userId = userId;
      this.grade = grade;
      this.rankratio = rank;
   }
   public User(String userId, int uLevel, String uTier) {
      this.userId = userId;
      this.uLevel = uLevel;
      this.uTier = uTier;
   }
   
   public int getGrade() {
      return grade;
   }
   public void setGrade(int grade) {
      this.grade = grade;
   }
   
   public int getRankratio() {
      return rankratio;
   }
   public void setRankratio(int rankratio) {
      this.rankratio = rankratio;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public int getuLevel() {
      return uLevel;
   }
   public void setuLevel(int uLevel) {
      this.uLevel = uLevel;
   }
   public String getuTier() {
      return uTier;
   }
   public void setuTier(String uTier) {
      this.uTier = uTier;
   }
   

}