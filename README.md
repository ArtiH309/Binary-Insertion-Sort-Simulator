Implements the following pseudocode algorithm: 
Algorithm BinaryInsertionSort(A[0…n-1])
//Sorts an array A of orderable elements using Insertion Sort with Binary Search
//Input: An array A[0…n-1] of n orderable elements
//Output: The array A sorted in ascending order
for i<-1 to n-1 do
   v <- A[i] //Binary Search Portion
   l<-0
   r<-i-1
   while l<=r do
      m <- [(l+r)/2]
      if v>A[m]
         l <- m+1
      else r <- m-1
   j <- i-1 //Insertion Sort Portion
   while j >= l do
      A[j+1] <- A[j]
      j <- j-1
   A[l] <- v
return A
Time Complexity Analysis: 
The worst-case would be an array sorted in reverse order (descending), and the key comparison is v>A[m], to see which half of the array the search continues in. Cworst(n)=Θ(nlogn), T(n) is the number of comparisons performed,  T(n)=T(n-1)+log(n-1)+1 for n>1, T(1)=0, T(n-1)=T(n-2)+log(n-2)+1, T(n)=T(n-2)+(log(n-2))+(log(n-1))+2, T(n-2)=T(n-3)+log(n-3)+1, T(n)=T(n-3)+(log(n-3))+(log(n-2))+(log(n-1))+3, T(k)=T(k-1)+Σ(i=1 to k)[log₂(n-i)+1], n-k=1, k=n-1, substitute T(1)+Σ[log₂(i)+(n-1)], approx log((n-1)!)+(n-1) becomes Θ(nlogn). The number of comparisons is nlogn, because it uses binary search (logn comparisons) to search the array (n times), so it performs the logn search n times for each sorted portion of the array. 
Overall worst case remains Θ(n^2) as the number of shifts when doing the insertion sorting part, as for the worst case reverse sorted array, Cworst(n)=n(n-1)/2, which is Θ(n^2) shifts, and T(n) = Θ(nlogn) comparisons + Θ(n^2) shifts is still Θ(n^2)
