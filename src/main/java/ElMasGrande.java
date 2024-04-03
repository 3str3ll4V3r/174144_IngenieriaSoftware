class ElMasGrande{
  //write a method to return the largest on an array
    public static int elMasGrande(int[] array){
      //check null array
      if(array == null){ 
        throw new IllegalArgumentException("Null Array");
      }
      //check empty array throw a exception
      if(array.length == 0){
        throw new IllegalArgumentException("Empty array");
      }
      int largest = array[0];
      for(int i = 0; i <= array.length-1; i++){
        if(array[i] > largest){
          largest = array[i];
        }
      }
    return largest;
  }
}