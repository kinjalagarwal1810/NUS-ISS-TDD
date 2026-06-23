package sg.edu.nus.iss.epat.tdd.workshop;

public class Task {
   private String description;
   private boolean isComplete;

   public Task(String description) {
      this(description, false);
   }

   public Task(String description, boolean isComplete) {
      this.description = description;
      this.isComplete = isComplete;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isComplete() {
      return isComplete;
   }

   public void setComplete(boolean isComplete) {
      this.isComplete = isComplete;
   }

}
