package com.hanxian.algorithm.leetcode.daily.questions;

import com.hanxian.algorithm.leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionInOrderPreOrderPostOrderTest {

    private SolutionInOrderPreOrderPostOrder solutionUnderTest;

    @Test
    void testPostOrder() {
        // Setup
        final TreeNode node = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2));

        // Run the test
        final List<Integer> result = solutionUnderTest.postOrder(node);

        // Verify the results
        assertThat(result).isEqualTo(List.of(3,4,1,2,0));
    }

    @BeforeEach
    void setUp() {
        solutionUnderTest = new SolutionInOrderPreOrderPostOrder();
    }

    @Test
    void testPreOrder() {
        // Setup
        final TreeNode node = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2));

        // Run the test
        final List<Integer> result = solutionUnderTest.preOrder(node);

        // Verify the results
        assertThat(result).isEqualTo(List.of(0,1,3,4,2));
    }
}
