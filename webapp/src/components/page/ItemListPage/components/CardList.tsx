import { Card } from "./Card";
import { Flex } from "@components/common/atoms/Flex";
import { useEffect, useState } from "react";
import { getItemList } from "@api/hooks/useGetItemList";
import { NewItem } from "@api/hooks/usePostItem";

export const CardList = () => {
  const [cards, setCards] = useState<NewItem[]>([]);

  useEffect(() => {
    const getCards = async () => {
      const response = await getItemList();
      setCards(response);
    };
    getCards();
  }, []);

  return (
    <Flex gap={8}>
      {cards.map((card) => (
        <Card key={card.itemId} {...card} />
      ))}
    </Flex>
  );
};
