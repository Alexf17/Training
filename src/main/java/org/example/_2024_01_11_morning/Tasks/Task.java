package org.example._2024_01_11_morning.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task {
   public List<String> filterByLength(List<String> input, int length){
//       List<String> sorted = new ArrayList<>();
//
//       for (int i = 0; i < input.size(); i++) {
//           if(input.get(i).length() > length){
//               sorted.add(input.get(i));
//           }
//       }
//       return sorted;
      return input.stream().filter(el -> el.length()> length).toList();

   };

   public List<String> toUpperCase(List<String> input){
//       return input.stream().map(el -> el.toUpperCase()).toList();
      List<String> result = new ArrayList<>();
      for (int i = 0; i <input.size() ; i++) {
        result.add(input.get(i).toUpperCase());

      }
      return result;
   }

   public Optional<String> findFirstStartingWith(List<String> input, char letter){
      return input.stream().filter(el ->el.startsWith(String.valueOf(letter))).findFirst();

   }
//   public String joinByComma(List<String> input){
//      return input
//   }
}
