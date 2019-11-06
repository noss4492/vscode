package simsimpoolyee;
/*
function genRanNum (count) {
  var numArray = [];

  for (let i = 0; i < count; i++) {
    numArray.push( Math.floor( Math.random() * 10 ) );
  }

  return numArray;
}

function quicksortMem (arrayToSort, cache = {}) {
  let left = [];
  let right = [];
  let key = arrayToSort.toString();

  if (arrayToSort.length <= 1) {
    return arrayToSort;
  }
  
  if (cache[key]) {
    return cache[key];
  }

  let pivot = arrayToSort.shift();

  while (arrayToSort.length) {
    let number = arrayToSort.pop();

    if (number < pivot) {
      left.push(number);

    } else {
      right.push(number)
    }
  }
  
  cache[key] = [ ...quicksortMem(left, cache), pivot, ...quicksortMem(right, cache) ];

  console.log(cache);
  
  return cache[key];
}
let randoms = genRanNum(100);
quicksortMem(randoms);
 
 */
public class QuickSortMemoization {
	public static void main(String[] args) {
	}
}
