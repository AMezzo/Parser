package visitor.images;

import ast.*;
import ast.trees.*;
import visitor.TreeVisitor;
import java.util.HashMap;
import java.util.Map;

public class OffsetVisitor extends TreeVisitor {

    private Map<AST, Offset> offsets = new HashMap<>();
    private int[] nextAvailableOffsets = new int[100];
    private int currentDepth = 0;

    private class Offset {
        private int x;
        private int y;

        public Offset(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private void processNode(AST node) {
        if (node.getChildren().isEmpty()) {
            offsets.put(node, new Offset(nextAvailableOffsets[currentDepth], currentDepth));
            nextAvailableOffsets[currentDepth]++;
            return;
        }
    
        int leftMostChildOffset = Integer.MAX_VALUE;
        int rightMostChildOffset = Integer.MIN_VALUE;
    
        currentDepth++;
        for (AST child : node.getChildren()) {
            visit(child);
            Offset childOffset = offsets.get(child);
            leftMostChildOffset = Math.min(leftMostChildOffset, childOffset.getX());
            rightMostChildOffset = Math.max(rightMostChildOffset, childOffset.getX());
        }
        currentDepth--;
    
        int parentNodeOffset = (leftMostChildOffset + rightMostChildOffset) / 2;
        if (parentNodeOffset < nextAvailableOffsets[currentDepth]) {
            int shiftAmount = nextAvailableOffsets[currentDepth] - parentNodeOffset;
            for (AST child : node.getChildren()) {
                Offset childOffset = offsets.get(child);
                offsets.put(child, new Offset(childOffset.getX() + shiftAmount, childOffset.getY()));
            }
            parentNodeOffset = nextAvailableOffsets[currentDepth];
        }
    
        offsets.put(node, new Offset(parentNodeOffset, currentDepth));
        nextAvailableOffsets[currentDepth]++;
    }
    
    @Override
    public Object visit(ProgramTree node) {
        processNode(node);
        return null;
    }
    
    @Override
    public Object visit(BlockTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(DeclarationTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(FunctionDeclarationTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(FormalsTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(IntTypeTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(BoolTypeTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(IfTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(WhileTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(ReturnTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(AssignmentTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(CallTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(ActualArgumentsTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(RelOpTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(AddOpTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(MultOpTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(IntTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(IdentifierTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(BinaryTypeTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(BinaryLitTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(CharTypeTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(CharLitTree node) {
        processNode(node);
        return null;
    }
    
    @Override
    public Object visit(IterationTree node) {
        processNode(node);
        return null;
    }

    @Override
    public Object visit(RangeTree node) {
        processNode(node);
        return null;
    }

    public Map<AST, Offset> getOffsets() {
        return offsets;
    }
}