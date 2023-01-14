package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftFactoryTests {
    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
        gift = new Gift("Superman", 1.5);
    }

    @Test
    public void test_getCount() {
        giftFactory.createGift(gift);
        int expected = 1;
        Assert.assertEquals(expected, giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_createGift_ReturnNullThrow() {
        giftFactory.createGift(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_createGift_ExceptionEqualName() {
        Gift presentNew = new Gift("Superman", 1.5);
        giftFactory.createGift(gift);
        giftFactory.createGift(presentNew);
    }

    @Test
    public void test_createGift() {
        giftFactory.createGift(gift);
        Assert.assertEquals("Superman", gift.getType());
    }

    @Test(expected = NullPointerException.class)
    public void test_removeGift_GiftIsNull() {
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_removeGift_GiftIsEmpty() {
        giftFactory.removeGift("    ");
    }

    @Test
    public void test_removeGift() {
        giftFactory.createGift(gift);
        Assert.assertTrue(giftFactory.removeGift("Superman"));
    }

    @Test
    public void getPresentWithLeastMagic() {
        Gift presentNew = new Gift("Spiderman", 5);
        giftFactory.createGift(gift);
        giftFactory.createGift(presentNew);
        Assert.assertEquals(gift, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void getPresent() {
        Gift presentNew = new Gift("Batman", 5);
        giftFactory.createGift(gift);
        giftFactory.createGift(presentNew);
        Gift actual = giftFactory.getPresent("Batman");
        Assert.assertEquals("Batman", actual.getType());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void IfTrueToModifiedCollectionThrowException(){
        this.giftFactory.createGift(this.gift);
        this.giftFactory.getPresents().remove(this.gift);

    }
}
