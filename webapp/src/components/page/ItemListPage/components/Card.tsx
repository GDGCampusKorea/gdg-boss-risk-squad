import { useFlow } from "@/lib/stackflow";
import { NewItem } from "@api/hooks/usePostItem";
import { Flex } from "@components/common/atoms/Flex";
import { Text } from "@components/common/atoms/Text";
import { Thumbnail } from "@components/common/atoms/Thumbnail";
import { styled } from "@linaria/react";

export const Card = ({ title, price, itemId }: NewItem) => {
  const { push } = useFlow();

  const imageUrl = `https://picsum.photos/800/800/?id=${itemId}`;

  const handlePostDetail = () => {
    push("ItemDetailPage", { itemId });
  };

  return (
    <CardWrapper onClick={handlePostDetail}>
      <Flex direction="row" gap={8}>
        <Thumbnail
          src={imageUrl}
          alt={title}
          width="108px"
          height="108px"
          borderRadius={8}
        />
        <Flex align="stretch" justify="space-between" height={80}>
          <Text>{title}</Text>
          <Text weight="bold">{price}원</Text>
        </Flex>
      </Flex>
    </CardWrapper>
  );
};

const CardWrapper = styled.div`
  width: 100%;
  padding: 8px;
  cursor: pointer;
`;
