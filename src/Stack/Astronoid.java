package Stack;

import java.util.Stack;

class Astronoid {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        if(asteroids.length<=1){
            return asteroids;
        }
        
        for(int asteroid : asteroids){
                //stack not empty
                // abs (asteroid)<abs(stack.peek)
                boolean isDistroyed = false;
                while(!stack.isEmpty() && asteroid<0 && stack.peek()>0){
                    if( Math.abs(asteroid)==Math.abs(stack.peek())){
                        stack.pop();
                        isDistroyed = true;
                        break;
                    }
                    else if( Math.abs(asteroid)>Math.abs(stack.peek())){
                        stack.pop();
                        isDistroyed = false;
                        
                    }
                    else if(Math.abs(asteroid)<Math.abs(stack.peek())){
                        isDistroyed = true;
                        break;
                    }   
                   
                }
                if(!isDistroyed){
                    stack.push(asteroid);    
                }
                

            }
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
            }
        

    }
