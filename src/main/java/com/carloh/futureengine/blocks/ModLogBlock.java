package com.carloh.futureengine.blocks;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;

public class ModLogBlock extends RotatedPillarBlock {
    public ModLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide) {
            world.levelEvent(2001, pos, Block.getId(state));
        }
        super.playerWillDestroy(world, pos, state, player);
    }
}
