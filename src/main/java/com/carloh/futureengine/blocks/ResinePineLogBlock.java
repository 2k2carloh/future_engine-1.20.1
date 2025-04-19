package com.carloh.futureengine.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import com.carloh.futureengine.item.Moditems;

public class ResinePineLogBlock extends RotatedPillarBlock {

    public ResinePineLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            ItemStack heldItem = player.getItemInHand(hand);

            if (heldItem.is(Items.SHEARS)) {
                ItemStack resineItem = new ItemStack(Moditems.RESINE.get());
                if (!player.getInventory().add(resineItem)) {
                    player.drop(resineItem, false);
                }

                BlockState pineState = Modblock.PINE_LOG.get().defaultBlockState()
                        .setValue(AXIS, state.getValue(AXIS));
                level.setBlock(pos, pineState, 3);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

                heldItem.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
