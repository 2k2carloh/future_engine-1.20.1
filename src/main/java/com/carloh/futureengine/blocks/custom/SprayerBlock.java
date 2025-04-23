package com.carloh.futureengine.blocks.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class SprayerBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public SprayerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();

        if (direction == Direction.NORTH) {
            return this.defaultBlockState().setValue(FACING, Direction.SOUTH);
        } else if (direction == Direction.SOUTH) {
            return this.defaultBlockState().setValue(FACING, Direction.NORTH);
        } else if (direction == Direction.WEST) {
            return this.defaultBlockState().setValue(FACING, Direction.EAST);
        } else {
            return this.defaultBlockState().setValue(FACING, Direction.WEST);
        }
    }
}
