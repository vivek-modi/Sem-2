package Generic.Q1;

class Counter <T>{
	  
	  private T value;
	  
	  public Counter(T v1) {
		  value = v1;
	  }
	  
	  public T readValue() {
		  return value;
	  }
	  
	  public void updateValue(T v1){
		  value = v1;
	  }
	  
  }