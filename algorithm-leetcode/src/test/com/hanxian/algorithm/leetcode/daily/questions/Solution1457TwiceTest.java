package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution1457TwiceTest {

    private Solution1457Twice solution1457TwiceUnderTest;

    @BeforeEach
    void setUp() {
        solution1457TwiceUnderTest = new Solution1457Twice();
    }

    @Test
    void testPseudoPalindromicPaths() {
        // Setup
        final TreeNode root = new TreeNode(0, null, null);

        // Run the test
        final int result = solution1457TwiceUnderTest.pseudoPalindromicPaths(root);

        // Verify the results
        assertThat(result).isEqualTo(1);
    }
}
