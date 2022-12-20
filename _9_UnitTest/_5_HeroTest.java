package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class _5_HeroTest {

    private static class FakeWeapon implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    @Test
    public void test_HeroGainsXP_When_Target_Killed() {
        Hero hero = new Hero("Javar", new FakeWeapon());

        assertEquals(0, hero.getExperience());

        Target target = new Target() {

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 200;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };


        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

    @Test
    public void test_HeroGainsXp_When_KillingTarget_Mocking_Example() {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Javar", weapon);

        assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(200);

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

    @Test
    public void test_HeroGainsXp_When_KillingTarget_Re_Example() {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Javar", weapon);

        assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(200);

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }
}