package ast;

import java.util.ArrayList;
import java.util.List;

import visitor.TreeVisitor;

public abstract class AST {
  public static int NodeCounter = 1;

  protected List<AST> children;
  private int nodeNumber;

  public AST() {
    this.children = new ArrayList<>();
    this.nodeNumber = AST.NodeCounter++;
  }

  public AST addChild(AST child) {
    this.children.add(child);

    return this;
  }

  public AST getChild(int index) {
    if (index < 0 || index >= this.children.size()) {
      return null;
    }

    return this.children.get(index);
  }

  public int getChildCount() {
    return this.children.size();
  }

  public List<AST> getChildren() {
    return this.children;
  }

  public int getNodeNumber() {
    return this.nodeNumber;
  }

  public abstract Object accept(TreeVisitor visitor);

}
