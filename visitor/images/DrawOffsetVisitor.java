package visitor.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import ast.*;
import ast.trees.*;
import java.util.Map;
import visitor.TreeVisitor;

public class DrawOffsetVisitor extends TreeVisitor {
    private OffsetVisitor offsetVisitor;
    private BufferedImage image;
    private Graphics2D graphics;
    private final int NODE_RADIUS = 25;
    private final int DIMENSION = 500;

    public DrawOffsetVisitor(OffsetVisitor offsetVisitor) {
        this.offsetVisitor = offsetVisitor;
        this.image = new BufferedImage(DIMENSION, DIMENSION, BufferedImage.TYPE_INT_RGB);
        this.graphics = image.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, DIMENSION, DIMENSION);
        graphics.setColor(Color.BLACK);
    }

    private void drawNode(AST node) {
        Offset offset = offsetVisitor.getOffsets().get(node);
        int x = offset.getX() * (NODE_RADIUS * 2 + 10);
        int y = offset.getY() * (NODE_RADIUS * 2 + 10);

        graphics.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);
        graphics.drawString(String.valueOf(node.getNodeNumber()), x, y);

        if (node.getParent() != null) {
            Offset parentOffset = offsetVisitor.getOffsets().get(node.getParent());
            int parentX = parentOffset.getX() * (NODE_RADIUS * 2 + 10);
            int parentY = parentOffset.getY() * (NODE_RADIUS * 2 + 10);
            graphics.drawLine(parentX, parentY, x, y);
        }
    }

    @Override
    public Object visit(ProgramTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }
    
    @Override
    public Object visit(BlockTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(ActualArgumentsTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(AddOpTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(AssignmentTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(BinaryTypeTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(BinaryLitTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(CallTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(CharLitTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(CharTypeTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(DeclarationTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(FormalsTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override    
    public Object visit(FunctionDeclarationTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(IdentifierTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(IfTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(IntTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(IntTypeTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(IterationTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(MultOpTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    @Override   
    public Object visit(RangeTree node) {
        drawNode(node);
        visitChildren(node);
        return null;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Map<AST, Offset> getOffsets() {
        return offsets;
    }

    public int getUnitWidth() {
        return unitWidth;
    }

    public int getUnitHeight() {
        return unitHeight;
    }
}