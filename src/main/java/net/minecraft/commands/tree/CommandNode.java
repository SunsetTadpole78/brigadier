package net.minecraft.commands.tree;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class CommandNode {
    private final List<CommandNode> children = Lists.newArrayList();

    public List<CommandNode> getChildren() {
        return children;
    }

    public void addChild(CommandNode node) {
        children.add(node);
    }
}
