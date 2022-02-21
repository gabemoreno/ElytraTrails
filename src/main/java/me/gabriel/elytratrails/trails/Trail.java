package me.gabriel.elytratrails.trails;

import me.gabriel.elytratrails.trailcomponents.SoundEffect;
import me.gabriel.elytratrails.util.ItemUtil;
import me.gabriel.elytratrails.util.TrailUtil;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Trail {


    private final ItemStack displayItem;
    private final Particle[] particles;
    private final SoundEffect[] soundEffects;
    private final List<ItemStack> itemList;


    public Trail(ItemStack displayItem, Material[] materials, ItemStack[] itemStacks, Particle[] particles, SoundEffect[] soundEffects) {
        this.displayItem = displayItem;
        this.displayItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.particles = particles;
        this.soundEffects = soundEffects;
        this.itemList = Arrays.stream(itemStacks).collect(Collectors.toList());
        Arrays.stream(materials).map(ItemStack::new).forEach(this.itemList::add);
        }

    public Trail(ItemStack displayItem, Material[] materials, Particle[] particles, SoundEffect[] soundEffects) {
        this.displayItem = displayItem;
        this.displayItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.particles = particles;
        this.soundEffects = soundEffects;
        this.itemList = Arrays.stream(materials).map(ItemStack::new).collect(Collectors.toList());
    }

    public Trail(ItemStack displayItem, ItemStack[] itemStacks, Particle[] particles, SoundEffect[] soundEffects) {
        this.displayItem = displayItem;
        this.displayItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.particles = particles;
        this.soundEffects = soundEffects;
        this.itemList = Arrays.asList(itemStacks);
    }

    public void dropItem(Player player) {
        if (itemList.isEmpty()) return;
        player.getWorld().dropItem(player.getLocation(), rollItem(itemList), TrailUtil::makeTrailItem);
    }

    public void spawnParticle(Player player) {
        if (particles.length == 0) return;
        player.getWorld().spawnParticle(particles[new Random().nextInt(particles.length)], player.getLocation(), 1);
    }

    public void playSound(Player player) {
        if (soundEffects.length == 0) return;
        rollEffect(soundEffects).play(player.getLocation());
    }

    public ItemStack getDisplayItem() {
        return displayItem;
    }

    public SoundEffect rollEffect(SoundEffect[] effects) {
        int[] rollArray = new int[Arrays.stream(effects).map(SoundEffect::getFrequency).mapToInt(Integer::intValue).sum()];
        for (int rollArrayIndex = 0 ; rollArrayIndex < rollArray.length ; rollArrayIndex++) {
            for (int effectsIndex = 0 ; effectsIndex < effects.length ; effectsIndex++) {
                for (int frequencyCounter = 0 ; frequencyCounter < effects[effectsIndex].getFrequency() ; frequencyCounter++) {
                    rollArray[rollArrayIndex] = effectsIndex;
                    rollArrayIndex++;
                }
            }
        }
        //Need to fix this in crate extras (nextInt bound is EXCLUSIVE, just need length not length-1)
        return effects[rollArray[new Random().nextInt(rollArray.length)]];
    }

    public ItemStack rollItem(List<ItemStack> itemStacks) {
        int[] rollArray = new int[itemStacks.stream().map(ItemUtil::getItemFrequency).mapToInt(Integer::intValue).sum()];
        for (int rollArrayIndex = 0 ; rollArrayIndex < rollArray.length ; rollArrayIndex++) {
            for (int itemIndex = 0 ; itemIndex < itemStacks.size() ; itemIndex++) {
                for (int frequencyCounter = 0 ; frequencyCounter < ItemUtil.getItemFrequency(itemStacks.get(itemIndex)) ; frequencyCounter++) {
                    rollArray[rollArrayIndex] = itemIndex;
                    rollArrayIndex++;
                }
            }
        }
        //Need to fix this in crate extras (nextInt bound is EXCLUSIVE, just need length not length-1)
        return itemStacks.get(rollArray[new Random().nextInt(rollArray.length)]);
    }

}
