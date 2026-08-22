class Solution{
public int[] dailyTemperatures(int[] temp){
int n=temp.length;
int[] result=new int[n];
Deque<Integer> stack=new ArrayDeque<>();
for(int i=n-1;i>=0;i--){
while(!stack.isEmpty()&&temp[stack.peek()]<=temp[i]){
stack.pop();
}
if(!stack.isEmpty())result[i]=stack.peek()-i;
else result[i]=0;
stack.push(i);
}
return result;
}
}