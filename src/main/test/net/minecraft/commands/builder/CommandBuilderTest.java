package net.minecraft.commands.builder;

import net.minecraft.commands.tree.LiteralCommandNode;
import org.junit.Before;
import org.junit.Test;

import static net.minecraft.commands.arguments.IntegerArgumentType.integer;
import static net.minecraft.commands.builder.RequiredArgumentBuilder.argument;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CommandBuilderTest {
    CommandBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new CommandBuilder("foo");
    }

    @Test
    public void testArguments() throws Exception {
        RequiredArgumentBuilder argument = argument("bar", integer());

        builder.then(argument);

        assertThat(builder.getArguments(), hasSize(1));
        assertThat(builder.getArguments(), hasItems((ArgumentBuilder) argument));
    }

    @Test
    public void testBuild() throws Exception {
        LiteralCommandNode node = builder.build();

        assertThat(node.getLiteral(), is("foo"));
    }

    @Test
    public void testBuildWithChildren() throws Exception {
        builder.then(argument("bar", integer()));
        builder.then(argument("baz", integer()));
        LiteralCommandNode node = builder.build();

        assertThat(node.getChildren(), hasSize(2));
    }
}