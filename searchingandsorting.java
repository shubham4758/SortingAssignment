1.// Solution


public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return new int[]{left + 1, right + 1}; // Adding 1 to the indices to match the 1-based indexing
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    // No solution found, so return an empty array or throw an exception, depending on the requirements
    return new int[0];
}



2.// Solution


public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};

    // Find the leftmost occurrence of the target
    int leftIndex = binarySearch(nums, target, true);
    if (leftIndex == nums.length || nums[leftIndex] != target) {
        // Target not found
        return result;
    }

    // Find the rightmost occurrence of the target
    int rightIndex = binarySearch(nums, target, false);

    // Set the starting and ending positions in the result
    result[0] = leftIndex;
    result[1] = rightIndex - 1;

    return result;
}

private int binarySearch(int[] nums, int target, boolean findLeftmost) {
    int left = 0;
    int right = nums.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > target || (findLeftmost && nums[mid] == target)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}



3.// Solution



public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < nums[mid + 1]) {
            // The peak must be on the right side
            left = mid + 1;
        } else {
            // The peak must be on the left side or at the mid index
            right = mid;
        }
    }

    return left;
}




4.// Solution


public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}



5.// Solution


public int majorityElement(int[] nums) {
    int majority = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == majority) {
            count++;
        } else {
            count--;
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
    }

    return majority;
}




6.// Solution



public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (isBadVersion(mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}



7.// Solution



public int countInversions(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
}

private int mergeSort(int[] nums, int left, int right) {
    int inversions = 0;

    if (left < right) {
        int mid = left + (right - left) / 2;

        inversions += mergeSort(nums, left, mid); // Count inversions in the left half
        inversions += mergeSort(nums, mid + 1, right); // Count inversions in the right half
        inversions += merge(nums, left, mid, right); // Merge and count inversions across the two halves
    }

    return inversions;
}

private int merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
    int inversions = 0;

    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            temp[k++] = nums[i++];
        } else {
            temp[k++] = nums[j++];
            inversions += mid - i + 1; // Count inversions when element in the right half is smaller
        }
    }

    while (i <= mid) {
        temp[k++] = nums[i++];
    }

    while (j <= right) {
        temp[k++] = nums[j++];
    }

    System.arraycopy(temp, 0, nums, left, temp.length); // Copy merged elements back to the original array

    return inversions;
}




8.// Solution



public void printCommonElements(int[] arr1, int[] arr2, int[] arr3) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < arr1.length && j < arr2.length && k < arr3.length) {
        if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            System.out.print(arr1[i] + " ");
            i++;
            j++;
            k++;
        } else if (arr1[i] < arr2[j]) {
            i++;
        } else if (arr2[j] < arr3[k]) {
            j++;
        } else {
            k++;
        }
    }
}
